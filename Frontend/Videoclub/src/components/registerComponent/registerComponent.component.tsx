export default const RegisterComponent: React.FC = () => {

    return (
        <section className="w-[500px] bg-slate-50 rounded-xl m-auto p-4">
            <form action="" className="flex flex-col justify-center items-center gap-4 my-4">
                <h2 className="text-2xl font-bold mb-4">Registrate</h2>
                <input type="email" name="email" id="email" className="bg-slate-200 p-4 w-96 rounded-lg" placeholder="Email"/>
                <input type="text" name="username" id="username" className="bg-slate-200 p-4 w-96 rounded-lg" placeholder="Usuario"/>
                <input type="password" name="password" id="password" className="bg-slate-200 p-4 w-96 rounded-lg" placeholder="Contraseña"/>
                <button type="submit" className="w-96 bg-blue-700 p-3 rounded-3xl transition duration-300 ease-in-out text-white hover:bg-blue-500">Confirmar</button>
                <p className="text-sm text-blue-700">
                    <a href="#" className="hover:underline">¿Ya tienes cuenta? Inicia sesión</a>
                </p>
            </form>
        </section>
    )

}