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
			agent{
				dockerfile {
					filename 'Dockerfile'
					dir '/tmp'
					args '-v /home/jenkins/workspace/cicd/cicd-gateway-test:/tmp'
				}
				
			}
			steps {
                sh "echo build finished..."
            }
		}

    }
    
    
}
