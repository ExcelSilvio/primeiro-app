package br.com.setcons.util;

import org.hibernate.jpa.event.internal.core.JpaAutoFlushEventListener;

public class CriaTabelas {

	public static void main(String[] args) {
		JPAUtil.createEntityManager();
		JPAUtil.closeEntityManager();
	}

}
