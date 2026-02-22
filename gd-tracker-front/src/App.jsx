function App() {

  return (
    <>
        <h1 className="text-3xl">Geometry Dash Progression Tracker</h1>
        <div className="overflow-x-auto bg-slate-900 p-6 text-slate-400">
            <table className="w-full text-left border-collapse">
                <thead>
                <tr className="border-b border-slate-700 text-slate-400">
                    <th className="p-3">Rank</th>
                    <th className="p-3">Name</th>
                    <th className="p-3">Creator(s)</th>
                    <th className="p-3">Attempts</th>
                    <th className="p-3">Enjoyment</th>
                    <th className="p-3">Completion Date</th>
                    <th className="p-3">Notes</th>
                </tr>
                </thead>
                <tbody className="text-white">
                    <tr className="border-b border-slate-800 hover:bg-slate-800 transition">
                        <td className="p-3">1</td>
                        <td className="p-3 font-semibold text-red-400">Bloodbath</td>
                        <td className="p-3">Riot & more</td>
                        <td className="p-3 text-slate-300">20,562</td>
                        <td className="p-3">55</td>
                        <td className="p-3">24/05/2021</td>
                        <td className="p-3">My hardest for nearly 4 years.</td>
                    </tr>
                    <tr className="border-b border-slate-800 hover:bg-slate-800 transition">
                        <td className="p-3">2</td>
                        <td className="p-3 font-semibold text-red-400">Cataclysm</td>
                        <td className="p-3">GBoy</td>
                        <td className="p-3 text-slate-300">6,000</td>
                        <td className="p-3">41</td>
                        <td className="p-3">06/02/2021</td>
                        <td className="p-3">Former hardest</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </>
  )
}

export default App
