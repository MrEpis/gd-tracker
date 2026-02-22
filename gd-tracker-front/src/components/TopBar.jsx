function TopBar({ viewingStats, onClick }) {

    return (
        <>
            {viewingStats ? (
                <div className="flex py-2 px-3 justify-start bg-neutral-900">
                    <button className="px-6 py-2 text-white bg-gray-500" onClick={onClick}>Back to levels</button>
                </div>
            ) : (
                <div className="flex py-2 px-3 justify-between bg-neutral-900">
                    <div className="flex space-x-4">
                        <button className="px-6 py-2 text-white bg-blue-500">Add demon</button>
                        <button className="px-6 py-2 text-white bg-gray-500" onClick={onClick}>See stats</button>
                    </div>
                    <div className="flex space-x-4">
                        <button className="px-6 py-2 text-white bg-gray-500">Import/Export as file</button>
                        <button className="px-6 py-2 text-white bg-red-500">Remove level</button>
                    </div>
                </div>
            )}
        </>
    );
}

export default TopBar;