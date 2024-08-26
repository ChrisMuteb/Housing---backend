pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6'
    }

    parameters {
        string(name: 'DB_HOST', defaultValue: 'postgresql.c7ki0kwsskvn.eu-west-1.rds.amazonaws.com', description: 'Database host')
        string(name: 'DB_PORT', defaultValue: '5432', description: 'Database port')
        string(name: 'DB_NAME', defaultValue: 'housing', description: 'Database name')
        string(name: 'DB_USERNAME', defaultValue: 'postgres', description: 'Database username')
        password(name: 'DB_PASSWORD', defaultValue: '', description: 'Database password')
    }

    stages {
        stage('Build Maven') {
            steps {
                script {
                    // Checkout the code
                    checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ChrisMuteb/Housing---backend.git']])

                    // Build the project using Maven
                    sh 'mvn clean install'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    sh """
                    docker build --build-arg DB_HOST=${params.DB_HOST} \
                                 --build-arg DB_PORT=${params.DB_PORT} \
                                 --build-arg DB_NAME=${params.DB_NAME} \
                                 --build-arg DB_USERNAME=${params.DB_USERNAME} \
                                 --build-arg DB_PASSWORD=${params.DB_PASSWORD} \
                                 -t chrismuteb/spring-boot-docker .
                    """
                }
            }
        }

        stage('Push Docker Image to Hub') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u chrismuteb -p ${dockerhubpwd}'
                        sh 'docker push chrismuteb/spring-boot-docker'
                    }
                }
            }
        }
    }
}
