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
        > **Christian Tzolov**: "Agents are only as useful as what they remember — conversation history alone isn't enough. When the window fills, important facts get evicted." [Blog Link](https://spring.io/blog/2026/04/07/spring-ai-agentic-patterns-6-memory-tools)