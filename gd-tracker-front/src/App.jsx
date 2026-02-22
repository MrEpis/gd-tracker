import { useEffect, useState} from "react";
import { demonService} from "./services/api.js";
import StatsScreen from "./features/StatsScreen.jsx";
import TopBar from "./components/TopBar.jsx";

function App() {
    const [demons, setDemons] = useState([]);
    const [loading, setLoading] = useState(true);
    const [viewingStats, setViewingStats] = useState(false);

    useEffect(() => {
        loadDemons();
    }, []);

    const loadDemons = async () => {
        try {
            setLoading(true);
            const response = await demonService.getAll();
            setDemons(response.data);
        } catch (error) {
            console.error("error while loading demons:", error);
        } finally {
            setLoading(false);
        }
    };

    function toggleViewingStats() {
        setViewingStats(!viewingStats);
    }

  return (
    <>
        <div className="min-h-screen bg-neutral-800 text-slate-50 p-4 md:p-8">
            <header className="max-w-6xl mx-auto mb-10">
                <h1 className="text-4xl font-black tracking-tighter text-amber-500">
                    Geometry Dash Progression Tracker
                </h1>
                <p className="text-slate-400 mt-2">Track your progression easily!</p>
            </header>

            <main className="max-w-6xl mx-auto space-y-8">
                <TopBar viewingStats={viewingStats} onClick={toggleViewingStats} />
            </main>
        </div>
    </>
  )
}

export default App
