def getHost(){
    def remote = [:]
    remote.name = 'registry'
    remote.host = '172.16.7.147'
    remote.user = 'root'
    remote.port = 22
    remote.password = 'abc123'
    remote.allowAnyHosts = true
    return remote
}

pipeline {
	agent none
	
	environment{
        def server = ''
    }
	
	options {
        skipDefaultCheckout()
        disableConcurrentBuilds()
    }
	
	stages {
		stage('init-server'){
            steps {
                script {                 
                   server = getHost()                                   
                }
            }
        }
	
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
						sh "docker -H tcp://172.16.7.147:2375 build  -t 'ocean-gateway/api:latest' ."
						sh "docker -H tcp://172.16.7.147:2375 tag gateway/api2:latest docker-registry-default.dev.ipaas.frxs.com/ocean-gateway/api:latest"
						sshCommand remote: server, command: "docker login -u opradm -p \$(oc whoami -t) docker-registry-default.dev.ipaas.frxs.com ;docker push docker-registry-default.dev.ipaas.frxs.com/ocean-gateway/api:latest"
					}
					
				}
            }
        }
		
	
    }
	
}   