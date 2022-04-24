# Short link generator 

В приложении есть несколько эндпоинтов:

1. /generate POST запрос для генерации коротких ссылок (через Постман или аналог)
2. /l/{shortLink} GET запрос в браузере, для редиректа на оригинальный URL
3. /stats/{shortLink} GET запрос для информации по одному URL
4. /stats с request params page и limit

Приложение развернуто на Heroku - https://linkshorter123.herokuapp.com

Используется база данных PosgreSQL (тоже поднята в Heroku)

С приложением можно работать локально, при использовании Docker (настройки базы данных для локального использования удалила, не стала добавлять в итоговый вариант, можно оставить в конфигурационном файле настройки локальной базы закоменченными, с комментарием о том что конфигурация нужна только для тестовой локальной базы)

Для запуска локально необходимо выполнить следующие команды:

1. Из корневой папки link - ./mvnw clean package -DskipTests
2. cp target/blog-api-docker.jar src/main/docker  
3. cd src/main/docker
4. docker-compose up


Стек технологий:
- Spring Boot
- Hibernate
- PostreSQL
- Docker

