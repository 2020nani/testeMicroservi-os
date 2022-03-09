import React, { useState } from 'react';
import { Container, Conteudo } from './styles'
import { Field, Form, Formik } from 'formik';
import apiRequest from '../../services/apiRequest';
import * as Yup from 'yup';

const schema = Yup.object().shape({
  name: Yup.string()
    .required('O nome é obrigatório'),
  email: Yup.string()
    .email('Insira um e-mail válido')
    .required('O e-mail é obrigatório'),
  cpf: Yup.string()
    .required('O cpf é obrigatório')
});

export default function CadastraUsuarioRedis() {


  return (
    <Container >
      <Conteudo>

        <Formik
          initialValues={{
            nome: '',
            email: '',
            password: '',
            admin: false
          }}
          validationSchema={schema}

          onSubmit={async (values) => {
            apiRequest.post("", values)
            window.location.reload("/")

          }
          }
        >
          {({
            touched,
            errors,
            setFieldValue,
          }) => (
            <Form >
              <Field name="name" placeholder="Digite seu nome" />
              {errors.name && touched.name ? (<div>{errors.name}</div>) : null}

              <Field name="email" placeholder="Digite seu email" />
              {errors.email && touched.email ? (<div >{errors.email}</div>) : null}

              <Field name="cpf" placeholder="Digite seu cpf" />
              {errors.cpf && touched.cpf ? (<div >{errors.cpf}</div>) : null}

              <button type="submit">{'Cadastrar'}</button>

            </Form>
          )}
        </Formik>
      </Conteudo>
    </Container>
  );
}