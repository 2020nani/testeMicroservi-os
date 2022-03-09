import styled from 'styled-components';

export const Container = styled.div`
display:flex;
justify-content:center;
align-items:center
width:100vw;
height: 22vh;
border-bottom: 1px solid skyblue

button{
  width: 8vw;
  background: ${function (props) { 
    let color = ""
    props.theme == "escuro" ? color = "rgb(28, 12, 63)" : color = "white" 
    return color } };
  border: ${function (props) { 
    let border = ""
    props.theme == "escuro" ? border = "1px solid white" : border = "1px solid skyblue" 
    return border } };
  border-radius: 10px;
  height: 6vh;
  font-weight: bold;
  color: black;
  padding: 0 15px;
  margin-top: 2vh;
  margin-bottom: 2vh;
  &::placeholder{
  color: (240, 248, 255, 0.1)
  }
};
}
`

export const ContainerButton = styled.div`
display:flex;
justify-content:space-between;
align-items:center
width:20vw;
margin-right: 1vw;
margin-left: 2vw;
`
