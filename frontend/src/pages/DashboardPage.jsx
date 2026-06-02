import { useNavigate } from "react-router-dom";

function DashboardPage() {
    const navigate = useNavigate();
    const user = JSON.parse(localStorage.getItem("user"));

    const account = {
        iban: "DE00100000000000000001",
        balance: 2500.0,
        currency: "EUR",
    };

    const transactions = [
        {
            id: 1,
            description: "Gehalt",
            amount: 2850.0,
            currency: "EUR",
            type: "INCOME",
            date: "2026-06-01",
        },
        {
            id: 2,
            description: "Supermarkt",
            amount: -45.99,
            currency: "EUR",
            type: "EXPENSE",
            date: "2026-06-02",
        },
        {
            id: 3,
            description: "Netflix",
            amount: -12.99,
            currency: "EUR",
            type: "EXPENSE",
            date: "2026-06-02",
        },
    ];

    function handleLogout() {
        localStorage.removeItem("user");
        navigate("/login");
    }

    return (
        <div>
            <h1>Dashboard</h1>

            <p>Willkommen, {user?.name}</p>

            <section>
                <h2>Kontostand</h2>
                <p>
                    {account.balance.toFixed(2)} {account.currency}
                </p>
                <p>IBAN: {account.iban}</p>
            </section>

            <section>
                <h2>Letzte Transaktionen</h2>

                <ul>
                    {transactions.map((transaction) => (
                        <li key={transaction.id}>
                            {transaction.date} — {transaction.description} —{" "}
                            {transaction.amount.toFixed(2)} {transaction.currency}
                        </li>
                    ))}
                </ul>
            </section>

            <button onClick={handleLogout}>Logout</button>
        </div>
    );
}

export default DashboardPage;