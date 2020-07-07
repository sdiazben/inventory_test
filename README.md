# Inventory test
## By: Sara Diaz

### To deploy: 

1. Open terminal and in inventory_test directory run: 
<pre><code>java -jar springbackend/target/springbackend-0.0.1-SNAPSHOT.jar</code></pre>

### To rebuild the jar: 

1. Building the frontend:  

  - Open terminal and go to directory inventory_test/angularfrontend  
  - Run command  
  <pre><code>ng build --prod</code></pre>


2. Coupling with the backend:  

  a. Open terminal and go back to directory inventory_test  
  b. Run command:  
  <pre><code>mvn clean install</code></pre>

3. Generates springbackend/target/springbackend-0.0.1-SNAPSHOT.jar then it can be deploy using deploy instruction
