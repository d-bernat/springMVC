pipeline {
    environment {
        registry = "dbernat/springmvc"
        registryCredential = 'dockerhub'
    }
    agent any

    triggers{
        pollSCM '* * * *'
    }

    stages {
        stage('Cloning git') {
            steps {
                git 'https://github.com/d-bernat/springMVC.git'
            }
        }
        stage('Building image') {
            steps {
                script {
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Deploy') {
            steps {
                docker push dbernat/springmvc
            }
        }
    }
}