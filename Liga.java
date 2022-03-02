
public class Liga {
	
	private String nombre;
	private Equipo[] equipos;
	private Calendario calendario;
	private Arbitro[] arbitros;
	private Clasificacion clasificacion;
	

	public Liga (String nombre, Equipo[] equipos, Arbitro[] arbitros) {
		this.nombre=nombre;
		this.equipos=equipos;
		this.arbitros=arbitros;
		this.calendario=new Calendario(this.equipos,this.arbitros);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Equipo[] getEquipos() {
		return equipos;
	}
	public void setEquipos(Equipo[] equipos) {
		this.equipos = equipos;
	}
	public Calendario getCalendario() {
		return calendario;
	}

	public Arbitro[] getArbitros() {
		return arbitros;
	}
	public void setArbitros(Arbitro[] arbitros) {
		this.arbitros = arbitros;
	}
	public Clasificacion getClasificacion() {
		this.clasificacion =  new Clasificacion(this.equipos,this.calendario);
		return clasificacion;
	}

	
	
}
