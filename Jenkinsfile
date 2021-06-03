pipeline {
    agent any

    stages {
        stage ('Clean Stage') {

                steps {
                    withMaven {
                        sh 'mvn clean'
                    }
                }
            }

        stage ('Compile Stage') {

            steps {
                withMaven {
                    sh 'mvn install'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven {
                    sh 'mvn deploy'
                }
            }
        }
    }
}