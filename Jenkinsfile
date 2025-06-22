pipeline {
    agent any

    tools {
        //maven 'Maven 3.8.1'
        nodejs 'NodeJS 20.10.0'
    }

    stages {
        stage('Clone Code') {
            steps {
                git 'https://github.com/RiyaaK17/crud-ci-cd-app.git'
            }
        }

        stage('Build Backend') {
            steps {
                dir('project') {
                    bat 'mvn clean install'
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir('youtube-course') {
                    bat 'npm install'
                    bat 'npm run build'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo ' Deploy logic goes here...'
            }
        }
    }
}
