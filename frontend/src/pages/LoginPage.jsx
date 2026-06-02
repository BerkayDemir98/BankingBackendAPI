import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";

function LoginPage() {
    const navigate = useNavigate();

    const [email, setEmail] = useState("berkay@example.com");
    const [password, setPassword] = useState("test123");

    function handleLogin(event) {
        event.preventDefault();

        const demoUser = {
            id: 1,
            name: "Berkay",
            email: email,
        };

        localStorage.setItem("user", JSON.stringify(demoUser));
        navigate("/dashboard");
    }

    return (
        <div>
            <h1>Login</h1>

            <form onSubmit={handleLogin}>
                <div>
                    <label>Email</label>
                    <br />
                    <input
                        type="email"
                        value={email}
                        onChange={(event) => setEmail(event.target.value)}
                    />
                </div>

                <div>
                    <label>Password</label>
                    <br />
                    <input
                        type="password"
                        value={password}
                        onChange={(event) => setPassword(event.target.value)}
                    />
                </div>

                <button type="submit">Einloggen</button>
            </form>

            <p>
                Noch kein Konto? <Link to="/register">Registrieren</Link>
            </p>
        </div>
    );
}

export default LoginPage;