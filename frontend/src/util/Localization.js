import LocalizedStrings from 'react-localization';
import {
    EMAIL_MAX_LENGTH,
    PASSWORD_MAX_LENGTH,
    PASSWORD_MIN_LENGTH
} from "../constants";

export const localizedStrings = new LocalizedStrings({

        en: {
            logout: "Logout",
            login: "Login",
            signUp: "Sign up",
            loginFormRegisterNow: " register now!",
            alreadyRegister: "Already registered?",
            signUpFromLoginNow: "Login now!",
            or: "or",
            email: "email",
            password: "Password",
            loginField: "Login",

            ///params
            confPassword: "Confirmed password",
            //alerts
            alertBadEmail: "Please input your email!",
            alertBadPassword: "Please input your Password!",
            alertSuccessRegister: "Thank you! You're successfully registered. Please Login to continue!",

            alertException: "Sorry! Something went wrong. Please try again!",


            //cert
            alertEmailNotValid: 'Email is not valid!',
            alertEmailToLong: `Email is too long (Maximum ${EMAIL_MAX_LENGTH} characters allowed)`,
            alertEmailAlreadyInUser: 'This Email is already registered',
            alertPasswordTooShort: `Password is too short (Minimum ${PASSWORD_MIN_LENGTH} characters needed.)`,
            alertPasswordTooLong: `Password is too long (Maximum ${PASSWORD_MAX_LENGTH} characters allowed.)`,
            alertConfPass: 'Confirmed pass do not match with pass',

            alertEmptyEmail: 'Email may not be empty',

            alertLoggedOut: 'You have been logged out. Please login create certificate.',


            alertWrongEmailOrPassword: 'Your Username or Password is incorrect. Please try again!',
            alertSuccessLogin: 'You are successfully logged in!',

            alertNoPermission: 'No permissions,Sorry!',
            alertSuccessLogOut: 'You are successfully logged out!',

            alertPageNotFound: " The Page you're looking for was not found. ",
            alertPageNoPermission: " You have no permission. Sorry!",

            ///helpers
            helpForPass: "A password between 6 to 20 characters",
            helpForEmail: "Your email",
        },
        ru: {
            logout: "Выйти",
            login: "Войти",
            signUp: "Регистрация",
            alreadyRegister: "Уже зарегистрированы?",
            loginFormRegisterNow: " зарегистрируйся сейчас!",
            signUpFromLoginNow: "Залогиньтесь!",
            or: "или",
            email: "Электронная почта",
            password: "Пароль",
            loginField: "Логин",

            ///params
            name: "Имя",
            confPassword: "Подтвержденный пароль",

            //alerts
            alertBadEmail: "Пожалуйста, введите Вашу электронную почту",
            alertBadPassword: "Пожалуйста, введите Ваш пароль",
            alertSuccessRegister: "Спасибо! Вы успешно зарегистрированы. Пожалуйста, залогиньтесь для продолжения!",

            alertException: "Извините! Что-то пошло не так. Попробуйте еще раз!",

            alertEmailNotValid: 'Email не корретный!',
            alertEmailToLong: `Email слишком длинный (Максимум ${EMAIL_MAX_LENGTH} символов)`,
            alertEmailAlreadyInUser: 'Этот email уже занят!',
            alertPasswordTooShort: `Пароль слишком короткий (Минимум ${PASSWORD_MIN_LENGTH} символов.)`,
            alertPasswordTooLong: `Пароль слишком длинный (Максимум ${PASSWORD_MAX_LENGTH} символов.)`,
            alertConfPass: 'Потвержденый пароль не совпал с паролем',

            alertEmptyEmail: 'Email не может быть пустым',

            alertWrongEmailOrPassword: 'Ваш логин или пароль неверны. Пожалуйста, попробуйте еще раз!',

            alertSuccessLogin: 'Успешный вход!',

            alertNoPermission: 'У вас нет прав, сори!',
            alertSuccessLogOut: 'Успешный выход!',
            alertPageNotFound: " Страница не найдена! ",
            alertPageNoPermission: " У вас нет прав, сори!",
            ///helpers
            helpForPass: "Пароль должен быть от 6 до 20 символов",
            helpForEmail: "Ваша электронная почта",
            helpForCertificateName: "Введите название телефона",
        }
    })
;
