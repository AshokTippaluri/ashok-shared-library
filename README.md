# ashok-shared-library
vars = The vars directory is a special directory that contains global variables that are defined in the shared library. These variables can be accessed from any Jenkins job that imports the shared library ( Contains Groovy functions accessible in pipelines. ).

src = The src directory is structured like a standard Java project. This means that you can use the import statement to import classes from other directories in the src directory ( Contains helper classes (for advanced use cases)).

resources = The resources directory is a regular directory that can contain any type of file. However, it is typically used to store static resources that are used by the shared library ( Holds configuration files or templates. ).

### Groovy
https://learnxinyminutes.com/groovy/
