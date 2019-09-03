pipeline {
	agent none
	
	options {
        skipDefaultCheckout()
        disableConcurrentBuilds()
    }
	
	stages {
        stage("Checkout") {
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
			agent {
					docker { image 'maven:latest'}
			}
            steps {
                sh "mvn package -DskipTests"
            }
        }
		
		stage("build"){
			steps {
				sh "docker build -t openshift/gateway:0.0.1 ."
			}
		}

    }
    
    
}
