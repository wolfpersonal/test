node {

	
	
        stage("Checkout") {
				agent {
					label 'maven'
				}
                library(identifier: "openshift-pipeline-library@master", 
                        retriever: modernSCM([$class: "GitSCMSource",
											  credentialsId: "wolfpersonal",
                                              remote: "https://github.com/wolfpersonal/test.git"]))
                
                initParameters() 
                
                gitClone()

                stash "repo"
				
				sh "mvn package -DskipTests"
           			
        }
		
		stage("build") {
			sh "docker build -t gateway/api:latest -f /home/jenkins/workspace/cicd/cicd-gateway-test/Dockerfile"			
		}
	
}   
