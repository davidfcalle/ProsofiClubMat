docker build -t clubmatbackend .
docker run --name backend \
	--link db:db \
	-d clubmatbackend bash