pipeline {
    agent any

    tools {
        jdk 'jdk25'
        maven 'Maven'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/kavindideepashika26-max/patient-api.git'
            }
        }

        stage('Build') {
            steps {
                dir('student-api') {
                    bat 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Docker Build') {
            steps {
                dir('patient-api') {
                    bat 'docker build -t patient-api .'
                }
            }
        }
    }
}