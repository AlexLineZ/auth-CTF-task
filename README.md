# SpringForumAuth (CTF-task)
## Сложность EASY

## Легенда
На форуме Пивчан какой-то `Troll228` позволил себе оскорбить моих родителей. Но я его в покое не оставлю... Самое время найти его номер и закинуть ему пару бомберов!

## Описание
У нас имеется стандарное REST приложение аутентификации форума.

Спецификация API (Swagger): `http://localhost:8080/swagger-ui/index.html`

Мой логин и пароль: `love_ctf@bababe.com` и `qwerty123`.
Токен требуется отправлять через кнопку Authorize.

*Задача*: получить флаг. Флагом является номер телефона негодяя.

## Флаг и аккаунты
Указываются в миграции БД

## Порт
Указывается в `application.yml` и необходимо изменить их в `Dockerfile` и `docker-compose`

## Запуск
Уже имеется настроенный `Dockerfile` и `docker-compose`. Сборка приложения вынесена в `Dockerfile`
Для запуска поднимите контейнеры `docker-compose up --build -d`

## Решение
1. Необходимо залогиниться под аккаунтом, выданном в описании
2. https://fusionauth.io/dev-tools/jwt-decoder - необходимо зайти на этот сайт, вписать полученный токен и в payload изменить значение `role` c `USER` на `ADMIN`
3. Ввести токен через кнопку Authorize.
4. В эндпоинте `/api/users/admin/profile/{nickName}` ввести имя `Troll228`.
5. Получить профиль и найти в нем флаг.
