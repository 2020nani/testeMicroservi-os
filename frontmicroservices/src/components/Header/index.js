import React from 'react';

import { Container, ContainerButton} from '../Header/styles';

export default function Header({setRoute}) {

  
  return (
    
    <Container>
      <h1>Testando nossa aplicação Microservice</h1>
      <ContainerButton>
      <button onClick={() => setRoute("Redis")}>Usuario Redis</button>
      <button onClick={() => setRoute("Normal")}>Usuario</button>
      </ContainerButton>
    </Container>
  );

}
