12 Factor App
    Demonstrates following attributes:
    * knows about Twelve-Factor App methodology for building software as a service (SAAS) applications and
        it's importance in building applications for cloud infrastructure over the past few years.
    * Knows about The Twelve Factors.
    * Knows and can explain at least 3-4 of The Twelve Factors, along with their examples and relevance.

    Demonstrates following attributes (in addition to previous-level attributes):
    * Is able to demonstrate usage of the Twelve-Factor App principles with examples.
    * Knows How to Use the Twelve-Factor App Methodology for Building SaaS Applications with languages like Java & Scala.
    * Is able to identify clearly the use cases where to Use the Twelve-Factor App Methodology for best practices
        for building modern, cloud-native applications.

12 Factors -
    CDCB2P2CDDLA

    One liners
    1. Codebase - Single codebase per application tracked in version control with many deploys(Git).
    2. Dependencies - Explicitly declare and isolate dependencies (Maven).
    3. Configuration - Store config in the environment.
    4. Backing Services - Treat backing services as attached resources.
    5. Build, Release and Run - Strictly separate built and run stages.
    6. Processes - Execute the application as one or more stateless processes.
    7. Port Binding - Export services via port binding.
    8. Concurrency - Scale out via the process model.
    9. Disposability - Maximize robustness with fast startup and graceful shutdown.
    10. Dev/Prod Parity - Keep development, staging, and production as similar as possible.
    11. Logs - Treat logs as event streams.
    12. Admin Processes - Run admin/management tasks as one-off processes.

    Detailed
    1. Codebase - One codebase tracked in revision control, many deploys (Git)
                  Let us break the official statement of it and try to understand the two main terms in it. In naive terms,
                  a codebase is all the human-written source code that doesn't include the class or object files generated
                  by the tools. A deploy refers to a single running instance of that particular application. Each application
                  must have only a single codebase. Each such codebase must be managed in a version control system. Some popular
                  VCS (Version Control System) includes git, svn and mercurial. It there exists multiple codebases, then it's not
                  an application, it's a distributed system. Each component of that system will be known as an application
                  that shall follow the principles of the 12-factor apps.
    2. Dependencies - Explicitly declare and isolate dependencies (Maven)
                      We all must have observed this at least once in our programming career that we have downloaded a python
                      library for some purpose and then found out that we have downloaded the wrong version of the library or
                      have the wrong version of python installed in our system. This generally happens because the task of
                      managing the dependencies is given to the developer. Hence, this factor states that we must always
                      declare the dependencies in the manifest file, a file containing the metadata for the dependencies
                      like name, version. It increases the speed of the development as now the developer is free from the
                      task of managing the correct version of the libraries. There is no need for explicitly downloading the required JARs anymore.
    3. Configuration - Config file should have externalized properties that has to be picked from env. variables. Ansible and chef can automate it
    4. Backing Services - The services on which our application depends. These are treated as attached resources.
                          This means swapping the compatible backing service should not require any code change.
                          The only change should be in configurations.
    5. Build, Release and Run -
        a. Build - Take the codebase, perform static and dynamic checks & generate executable bundle like jar.
        b. Release - Take the executable bundle and combine this with the right configurations. Here, we can use Packer
                     with a provisioner like Ansible to create Docker images
        c. Run - Run the application in a target execution environment. If we use Docker as the container to release our
                 application, running the application can be simple enough

        Finally, we don't necessarily have to perform these stages manually. This is where Jenkins comes in as pretty
            handy with their declarative pipeline.
    6. Processes - A twelve-factor app is expected to run in an execution environment as stateless processes.
                   In other words, they can not store persistent state locally between requests. They may generate
                   persistent data which is required to be stored in one or more stateful backing services.
        Note - If we keep track of user requests in-memory and use that information to serve future requests, it violates a twelve-factor app
    7. Port Binding - WAR or web archive is typically a collection of Servlets with dependencies, and it expects a
                      conformant container runtime like Tomcat. A twelve-factor app, on the contrary, expects no such
                      runtime dependency. It's completely self-contained and only requires an execution runtime like Java.
                      It binds itself to some particular port and listens to all the requests hitting on that port.
    8. Concurrency - Kubernetes can be used to create multiple instances of an app for load distribution.
    9. Disposability - Application should expose idempotent(if same operation is performed more than once then it
                       should not result in data duplicacy) services.
    10. Dev/Prod Parity - The twelve-factor methodology suggests keeping the gap between development and production
                          environment as minimal as possible. These gaps can result from long development cycles, different
                          teams involved, or different technology stack in use.
    11. Logs - It provides invaluable insights into the working of the application. Typically an application can generate logs
               at multiple levels with varying details and output in multiple different formats.
               A twelve-factor app, however, separates itself from log generation and its processing. For such an app,
               logs are nothing but a time-ordered stream of events. The capture, storage, curation, and archival of such
               stream should be handled by the execution environment. Ex. SLF4j and Fluentd. This we can feed into
               Elasticsearch for storage and indexing. Finally, we can generate meaningful dashboards for visualization in Kibana.
    12. Admin Processes - Now, the twelve-factor methodology strongly suggests keeping such admin scripts together with
                          the application codebase. In doing so, it should follow the same principles as we apply to the main application codebase.
                          It's also advisable to use a built-in REPL tool of the execution environment to run such scripts on production servers.