pipeline {
	agent none
	tools {
		docker {
			registryUrl "docker-registry-default.dev.ipaas.frxs.com"
			args " -v /home/jenkins/workspace/cicd/cicd-gateway-test/:/home/jenkins/workspace/cicd/cicd-gateway-test/ -f /home/jenkins/workspace/cicd/cicd-gateway-test/Dockerfile"
		}
	}
	
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
				script{
					docker.withTool('docker'){
						echo "image build start"
						def dockerImage = docker.build("gateway/api:latest")
						echo "image build finished"
						dockerImage.push()
					}
				}
            }
        }
		
	
    }
	
}   