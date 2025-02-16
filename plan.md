# Перечень тестов для проверки основного функционала:
- Покупка тура с использованием валидных данных
- Покупка тура в кредит с использованием валидных данных
- Покупка тура с использованием валидных данных, но с картой находящейся в списке невалидных
- Покупка тура с пустыми полями ввода
- Покупка тура в кредит с пустыми полями ввода
- Покупка тура в кредит с использованием валидных данных, но с картой находящейся в списке невалидных

# Перечень тестов для проверки полей ввода:
- Покупка с помощью APPROVED карты (данная карта разрешена для использования на сервисе)
- Покупка с помощью DECLINED карты (данная карта отклонена для использования на сервисе)
- Покупка с полностью пустыми полями ввода
- Невалидное заполнение поля “номер карты” (буквы латинского алфавита или кириллицы, знаки препинания и спецсимволы)
- Невалидное заполнение поля “номер карты” (пустое поле)
- Невалидное заполнение поля “месяц” (буквы латинского алфавита или кириллицы, знаки препинания и спецсимволы)
- Невалидное заполнение поля “месяц” (пустое поле)
- Невалидное заполнение поля “год” (буквы латинского алфавита или кириллицы, знаки препинания и спецсимволы)
- Невалидное заполнение поля “год” (пустое поле)
- Невалидное заполнение поля “владелец” (кириллица, цифры, спецсимволы кроме дефиса и пробела)
- Невалидное заполнение поля “владелец” (оставить поле пустым)
- Невалидное заполнение поля “владелец” (меньше 2 или больше 16)
- Невалидное заполнение поля ввода “CVV” (спецсимволы или буквы кириллицы и латинского алфавита)
- Невалидное заполнение поля ввода “CVV” (оставить поле пустым)

# Инструменты:
1. IntelliJ IDEA Community Edition 2023.1.2
2. Docker Desktop
3. DBeaver
4. Скриншоттер
5. Postman
6. Java 11
7. Gradle
8. Git Bash
9. Git Hub
10. Lombok
11. Selenide
12. Faker
13. Allure

# Возможные риски и сложности:
1. Поиск css селекторов или data-test-id
2. Имеется риск, что при изменении сайта, придется переписать часть автотестов

# Интервальная оценка с учетом рисков в часах:
1. Планирование автоматизации - 2 часа
2. Написание основного кода логики взаимодействия - 30 часов
3. Подключение и настройка баз данных - 4 часа
4. Написание основного кода автотестов - 20 часов
5. Составление отчетов - 2 часа

# План сдачи дипломной работы:
Автотесты будут готовы к дате 14/02/2025
