import React, { useEffect, useState } from 'react';
import { Container, Table } from './styles'
import { toast } from 'react-toastify';
import api from '../../services/api';


export default function CadastraUsuario() {


  const [usuariosRedis, setUsuariosRedis] = useState([]);


  useEffect(() => {
    async function listarUsuarioRedis() {
      const response = await api.get(`redis/user`);
      setUsuariosRedis(response.data)
    }

    listarUsuarioRedis()
  }, []);


  async function cadastraUsuario(data) {
    try {
      const response = await api.post("/user", data)
      response.data.includes("Ja ha um usuario cadastrado com o nome") ? toast.error(response.data) : toast.success(response.data)
      window.location.reload()
    } catch (err) {
      return err
    }
  }

  async function removeUsuarioRedis(userId) {
    try {
      const response = await api.delete(`/user/${userId}`)
      toast.success("Deletado com sucesso")
      window.location.reload()
    } catch (err) {
      return err
    }
  }

  return (

    <Container>
      {usuariosRedis.map(userRedis => (
        <Table>
          <thead>
            <tr>
              <th>Id</th>
              <th>name</th>
              <th>email</th>
              <th>cpf</th>
              <th>Aceitar</th>
              <th>Negar</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>{userRedis.id}</td>
              <td>{userRedis.name}</td>
              <td>{userRedis.email}</td>
              <td>{userRedis.cpf}</td>
              <td><button onClick={() => cadastraUsuario(userRedis)}>Aceitar</button></td>
              <td><button onClick={() => removeUsuarioRedis(userRedis.id)}>Negar</button></td>
            </tr>
          </tbody>
        </Table>
      ))}
    </Container>
  );

}