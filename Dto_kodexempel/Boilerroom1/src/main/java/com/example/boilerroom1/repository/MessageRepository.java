package com . example . boilerroom1 . repository ;
import com . example . boilerroom1 . entity . Message ;
import org . springframework . data . jpa . repository . JpaRepository ;
public interface MessageRepository
        extends JpaRepository < Message , Long >
{}

