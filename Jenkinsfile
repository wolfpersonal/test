pipeline {
	agent any
	
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
            steps {
                sh "mvn package -DskipTests"
				sh 'docker build -t gateway/api:latest .' 
            }
        }
		
		stage("build") {
			steps {
                sh "echo build finished..."
            }
		}

    }
    
    
}
