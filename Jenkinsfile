pipeline {
    agent any

    stages {
        stage ('Clean Stage') {

                steps {
                    withMaven {
                        sh 'clean'
                    }
                }
            }

        stage ('Compile Stage') {

            steps {
                withMaven {
                    sh 'install'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven {
                    sh 'test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven {
                    sh 'deploy'
                }
            }
        }
    }
}