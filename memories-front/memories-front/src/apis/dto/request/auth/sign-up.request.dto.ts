// interface: sign up request body dto //
export default interface SignUpRequestDto {
    userId: string;
    userPassword: string;
    name: string;
    address: string;
    detailAddress: string | null;
    joinType: 'NORMAL' | 'KAKAO' | 'NAVER';
}
