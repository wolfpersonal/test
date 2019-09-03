pipeline {
	agent {
		label "maven"
	}
	
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
		stage("build"){
			steps {
				sh "echo 'start to build image...'"
				archiveArtifacts artifacts: '**/target/ocean-api-0.0.1-SNAPSHOT.jar', fingerprint: true
				agent {
					dockerfile true
				}
			}
		}

    }
    
    
}
