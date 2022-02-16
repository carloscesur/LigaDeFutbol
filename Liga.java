public class Liga {

	//ATRIBUTOS
	private String nombre;
	private Equipo[] equipos;
	private Calendario calendario;
	private Arbitro[] arbitros;
	private Clasificacion clasificacion;

	//CONSTRUCTOR
	public Liga(Equipo[] equipos, Arbitro[] arbitros){

		this.nombre = "Liga Sin Nombre";
		this.equipos = equipos;
		this.arbitros = arbitros;
		this.calendario = new Calendario(this.equipos);
		this.clasificacion = new Clasificacion();
	}

	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}
	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros = arbitros;
	}
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	//GETTERS
	public String getNombre() {
		return nombre;
	}
	public Equipo[] getEquipos() {
		return equipos;
	}
	public Calendario getCalendario() {
		return calendario;
	}
	public Arbitro[] getArbitros() {
		return arbitros;
	}
	public Clasificacion getClasificacion() {
		return clasificacion;
	}
}
