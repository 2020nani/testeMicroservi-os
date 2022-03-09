import styled from 'styled-components';

export const Container = styled.div`
width: 100vw;
height: 80vh;
display: flex;
justify-content: center;
align-items: center;
background-color: white
`
export const Conteudo = styled.div`
width: 100vw;
max-width: 400px;
text-align: center;
@media (max-width:400px) {
    max-width:300px
  }
form{
    display: flex;
    flex-direction: column;
    margin-top: 2vh;
    margin-bottom: 2vh;
}
input {
    background: rgba(0, 0, 0, 0.1);
    border: 0;
    border-radius: 4px;
    height: 45px;
    padding: 0 15px;
    color: black;
    margin-top: 2vh;
    &::placeholder{
    color: (240, 248, 255, 0.1)
    }
}
    
button{
    background: #5F9EA0
    border: 0;
    border-radius: 4px;
    height: 45px;
    font-weight: bold;
    color: white;
    padding: 0 15px;
    color: black;
    margin-top: 2vh;
    margin-bottom: 2vh;
    font-size:14px
    &::placeholder{
    color: (240, 248, 255, 0.1)
    }
}
`
