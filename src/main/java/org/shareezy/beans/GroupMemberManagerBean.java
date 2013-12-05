package org.shareezy.beans;

import javax.faces.bean.ManagedBean;

/** Beschreibung von GroupMemberManagerBean 
*
* @author Timo Kuchling
* @version Dez 5, 2013 - 09:23Uhr
*/
@ManagedBean(name="MemberManager")
public class GroupMemberManagerBean {
	
	/** Die Methode AddUser dient dazu dem Benutzer eine Gruppe zuzuweisen
	 * 
	 *  - wird bei Klick auf 'Hinzufügen' und 'Annehmen' aufgerufen
	 *  - erstellt die Zuweisung in der AccountsGruppen Entität
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String addUser(){
		return null; 
		}
	
	/** Die Methode deleteUser dient dazu die Gruppenzuweisung eines Benutzers zu entfernen
	 * 
	 *  - wird bei Klick auf 'Entfernen' aufgerufen
	 *  - löscht die Zuweisung in der AccountsGruppen Entität
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteUser(){
		return null; 
		}
	
	/** Die Methode deleteRequest dient dazu eine Anfrage in der Gruppendetailansicht zu entfernen
	 * 
	 *  - wird bei Klick auf Ablehnen aufgerufen
	 *  @return gibt nichts zurück damit sich die View nicht ändert
	 */
	public String deleteRequest(){
		return null; 
	}
}
