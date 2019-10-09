pipeline {
	agent none
	
	options {
        skipDefaultCheckout()
        disableConcurrentBuilds()
    }
	
	stages {
        stage("Checkout") {
			agent{
				label "maven"
			}
            steps {     
                library(identifier: "openshift-pipeline-library@master", 
                        retriever: modernSCM([$class: "GitSCMSource",
											  credentialsId: "wolfpersonal",
                                              remote: "https://github.com/wolfpersonal/test.git"]))
                
                initParameters() 
                
                gitClone()

                stash "repo"
            }
			
        }
		
		stage("Compile") {
			agent{
				label "maven"
			}
            steps {
                sh "mvn package -DskipTests"
				script {
					docker.withTool('docker'){
						echo "image build start"
						sh "docker -H tcp://172.16.7.147:2375 build  -t 'gateway/apis:latest' ."
						sh "docker -H tcp://172.16.7.147:2375 login -u opradm -p \$(oc whoami -t) docker-registry-default.dev.ipaas.frxs.com | docker -H tcp://172.16.7.147:2375 tag gateway/apis:latest docker-registry-default.dev.ipaas.frxs.com/gateway/apis:latest | docker -H tcp://172.16.7.147:2375 push docker-registry-default.dev.ipaas.frxs.com/gateway/apis:latest"
					}
				}
            }
        }
		
	
    }
	
}   