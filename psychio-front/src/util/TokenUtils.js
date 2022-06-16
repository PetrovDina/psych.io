class TokenUtils {
    getUser = () => {
      let token = sessionStorage.getItem('token');
      if (token) {
        let tokenData = JSON.parse(atob(token.split('.')[1]));
        return tokenData;
      }
      return { ROLE: 'NONE' };
    };
  }
  
  const tokenUtils = new TokenUtils();
  export default tokenUtils;
  