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
            }
        }
	
		
		stage("build") {
			agent {
				docker {
					args "-v /home/jenkins/workspace/cicd/cicd-gateway-test/:/home/jenkins/workspace/cicd/cicd-gateway-test/ -f /home/jenkins/workspace/cicd/cicd-gateway-test/Dockerfile"
				}
			}
			steps {
				sh "docker build -t 'gateway/api:latest'"
			}
		}
	
    }
	
}   