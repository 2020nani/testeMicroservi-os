import styled from 'styled-components';

export const Container = styled.div`
width: 100vw;
height: 100%;
display: flex;
flex-direction: column;
justify-content:center;
align-items: center;
font-family: Arial, Helvetica, sans-serif;
h1{
  margin-top: 20px;
  text-align:left
}
p{
  text-align:left;
  font-size:1.5rem
}
`
export const Table = styled.table`
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 60%;
  tr:nth-child(even){background-color: #f2f2f2;}
  tr:hover {background-color: #ddd;}
  th {
  padding: 0.5em;
  text-align: center;
  background-color: #04AA6D;
  color: white;
}
td {
  padding: 0.5em;
  text-align: center;
  background-color: skyblue;
  color: white;
  button{
    width:60px;
    background-color: transparent;
    border-radius: 10px;
  }
}

`
