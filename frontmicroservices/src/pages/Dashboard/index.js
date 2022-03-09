import React, { useState } from 'react';
import Header from '../../components/Header';
import CadastraUsuario from '../../components/CadastraUsuario';
import CadastraUsuarioRedis from '../../components/CadastraUsuarioRedis';
import { Container } from './style';
export default function Dashboard() {

  const [route, setRoute] = useState("Redis");

  return (

    <Container >
      <Header 
      route={route} 
      setRoute={setRoute}
      />
    { route == "Redis" ? <CadastraUsuario /> : <CadastraUsuarioRedis />}
    </Container>
  );

}