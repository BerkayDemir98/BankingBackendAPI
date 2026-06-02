import { Link } from "react-router-dom";

function RegisterPage() {
    return (
        <div>
            <h1>Registrieren</h1>

            <form>
                <div>
                    <label>Name</label>
                    <br />
                    <input type="text" />
                </div>

                <div>
                    <label>Email</label>
                    <br />
                    <input type="email" />
                </div>

                <div>
                    <label>Password</label>
                    <br />
                    <input type="password" />
                </div>

                <button type="submit">Registrieren</button>
            </form>

            <p>
                Schon ein Konto? <Link to="/login">Zum Login</Link>
            </p>
        </div>
    );
}

export default RegisterPage;