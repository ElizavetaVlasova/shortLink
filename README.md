Short link generator

В приложении есть несколько эндпоинтов:

/generate POST запрос для генерации коротких ссылок (через Постман или аналог)
/l/{shortLink} GET запрос в браузере, для редиректа на оригинальный URL
/stats/{shortLink} GET запрос для информации по одному URL
/stats с request params page и limit
Приложение развернуто на Heroku - https://linkshorter123.herokuapp.com

Используется база данных PosgreSQL (тоже поднята в Heroku)

С приложением можно работать локально, при использовании Docker (настройки базы данных для локального использования удалила, не стала добавлять в итоговый вариант, можно оставить в конфигурационном файле настройки локальной базы закоменченными, с комментарием о том что конфигурация нужна только для тестовой локальной базы)

Для запуска локально необходимо выполнить следующие команды:

Из корневой папки link - ./mvnw clean package -DskipTests
cp target/blog-api-docker.jar src/main/docker
cd src/main/docker
docker-compose up
Стек технологий:

Spring Boot
Hibernate
PostreSQL
Docker
Maven
