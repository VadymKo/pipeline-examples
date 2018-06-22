// Only entire pipeline`s can be defined in shared libraries as of this time. 
// This can only be done in `vars/*.groovy, and only in a call method. 
// Only one Declarative Pipeline can be executed in a single build, 
// and if you attempt to execute a second one, your build will fail as a result.

// vars/evenOrOdd.groovy
def call(int buildNumber) {
  if (buildNumber % 2 == 0) {
    pipeline {
      agent any
      stages {
        stage('Even Stage') {
          steps {
            echo "The build number is even"
          }
        }
      }
    }
  } else {
    pipeline {
      agent any
      stages {
        stage('Odd Stage') {
          steps {
            echo "The build number is odd"
          }
        }
      }
    }
  }
}
