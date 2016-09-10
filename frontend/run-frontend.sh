docker build -t clubmatfrontend .
docker run --name clubmatfrontend \
	--link db:db \
	-d clubmatfrontend bash