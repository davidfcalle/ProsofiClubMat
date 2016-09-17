docker build -t clubmatdb .
docker run --name clubmatdb \
    -P 3306:3306
	-d clubmatdb