import { Component } from '@angular/core';

@Component({
    selector: 'login',
    template: `<section id="main-container">
        <div class="container">
            <div class="row">
                <div class="col s10 push-s1">
                    <div class="row">
                        <div class="col m5 hide-on-small-only">
                            <img src="images/login.png" class="login-image" alt="">
                        </div>
                        <div class="col s12 m7">
                            <div class="row">
                                <div class="signup-box">
                                    <h1 class="login-title"> Prosofi Clubmat </h1>
                                    <form action="" class="signup-form">
                                        <h2> Regístrate como administrador o participante de una olimpiada </h2>
                                        <div class="section">
                                            <a class="btn btn-fb hide-on-med-and-up"> Iniciar Sesión </a>
                                        </div>
                                        <div class="divider"></div>
                                        <div class="section">
                                            <input type="text" name="username" placeholder="Nombre de Usuario" />
                                            <input type="password" name="password" placeholder="Contrase&ntilde;a" />
                                            <input type="email" name="email" placeholder="Correo Electrónico" />
                                            <input type="text" name="name" placeholder="Nombre Completo" />
                                            <input type="text" name="direccion" placeholder="Direcci&oacute;n" />
                                            <input type="text" name="ciudad" placeholder="Ciudad" />
                                            <input type="text" name="celular" placeholder="Celular" />
                                            <input type="text" name="rol" placeholder="Rol" />
                                            <button class="btn waves-effect waves-light btn-signup" type="submit"> Crear Usuario </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="row">
                                <div class="login-box">
                                    ¿Tienes una cuenta ? <a href="/signup">Entrar</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>`
})
export class AppComponent { }
