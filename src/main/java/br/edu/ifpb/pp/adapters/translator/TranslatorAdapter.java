package br.edu.ifpb.pp.adapters.translator;

public interface TranslatorAdapter {
    public String translate(String text, String targetLanguage) throws Exception;
}
