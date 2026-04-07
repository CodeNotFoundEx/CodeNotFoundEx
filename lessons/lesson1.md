# What I Did Not Know While Coding This Project

1. **IntelliJ IDEA & Multiple Spring Boot Projects**
   - IntelliJ IDEA no longer complains if you have multiple Spring Boot projects in the same folder.
   - All you need to do is create a `compose.yaml` file in the root folder that includes all projects.

2. **PROS/CONS of Keeping All Spring Boot Projects in the Same Folder**
   - PROS:
        1. **AI Integration**: Improved context for AI tools.
        2. **Microservices Management**: It's somtimes "easier" to manage multiple microservices in one folder.
   - CONS:
      1. **Microservices Management**: Everything is in one git repository. 
      2. **AI Context**: AI context can get overflown when you have multiple microservices that do not have a clear boundaries.