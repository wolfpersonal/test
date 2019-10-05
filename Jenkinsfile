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
		
	
    }
	
}   
node {
	docker.withServer("tcp://172.16.7.147"){
		def dockerImage = docker.build("gateway/api:latest","-f /home/jenkins/workspace/cicd/cicd-gateway-test/Dockerfile")
		echo "image build finished"
		dockerImage.push("docker-registry-default.dev.ipaas.frxs.com/gateway/api:latest")
	}
	usleep(200000000)
}