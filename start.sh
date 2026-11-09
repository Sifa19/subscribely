
#!/bin/bash

# Load environment variables
set -a
source .env
set +a

# Start Docker
docker start subscribely-postgres
docker ps

# Start Spring Boot
./mvnw spring-boot:run


# chmod +x start.sh
#docker ps
#./start.sh