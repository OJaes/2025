import { IdCheckRequestDto } from './dto/request/auth';
import axios, { AxiosError, AxiosResponse } from 'axios';
import { ResponseDto } from './dto/response';
import SignUpRequestDto from './dto/request/auth/sign-up.request.dto';

// variable: URL 상수 //
const API_DOMAIN = process.env.REACT_APP_API_DOMAIN;
const AUTH_MODULE_URL = `${API_DOMAIN}/api/v1/auth`;

const ID_CHECK_URL = `${AUTH_MODULE_URL}/id-check`;
const SIGN_UP_URL = `${AUTH_MODULE_URL}/sign-up`;

// function: response 성공 처리 함수 //
const responseSuccessHandler = (response: AxiosResponse<ResponseDto, any>) => {
    const { data } = response;
    return data;
};

// function: response 실패 처리 함수 //
const responseErrorHandler = (error: AxiosError<ResponseDto, any>) => {
    if (!error.response) return null;
    const { data } = error.response;
    return data;
};

// function: id check API 요청 함수//
// 동기 비동기 - async, await
export const idCheckRequest = async (requestBody: IdCheckRequestDto) => {
    const responseBody = await axios
        .post(ID_CHECK_URL, requestBody)
        .then(responseSuccessHandler)
        .catch(responseErrorHandler);
    return responseBody;
};

// function: sign up API 요청 함수 //
export const signUpRequest = (requestBody: SignUpRequestDto) => {
    const responseBody = axios.post(SIGN_UP_URL, requestBody).then(responseSuccessHandler).catch(responseErrorHandler);
};
